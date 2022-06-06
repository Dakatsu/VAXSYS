package com.vaxsys;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * A simple console to interact with VAXSYS.
 * Sends the proper HTTP requests and decodes the responses.
 * The console can be easily extended with new functions by
 * adding an "exec" prefix to them; the system automatically
 * interprets any following text as parameters and attempts
 * to execute it.
 */
public class VaxsysUserConsole {

    /**
     * The list of executable console methods we find.
     */
    public Method[] execMethods;

    /**
     * The address of the VAXSYS server with which to prefix requests.
     */
    public String urlPrefix = "http://localhost:9000";

    /**
     * Initalizes the console with a specific server address.
     * @param serverAddress The address to use for the server.
     */
    public VaxsysUserConsole(String serverAddress) {
        this.urlPrefix = serverAddress;
        execMethods = this.getClass().getDeclaredMethods();
    }

    /**
     * Inlitializes the console with the default server address.
     */
    public VaxsysUserConsole() {
        this("http://localhost:9000");
    }

    /**
     * Returns a connection's HTTP response message, including for error codes.
     * @param connection The connection whose message to decode.
     * @return The response message, including response code.
     */
    public static String getHttpResponseMessage(HttpURLConnection connection) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer response = new StringBuffer();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            reader.close();
            return connection.getResponseCode() + ": " + response.toString();
        } catch (IOException e) {
            reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            StringBuffer response = new StringBuffer();
            String line;
            try {
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                    response.append('\r');
                }
                reader.close();
                return connection.getResponseCode() + ": " + response.toString();
            } catch (IOException f) {
                return "Error when attempting to get response.";
            }
        }
    }

    /**
     * Sends an HTTP POST request and prints the response.
     * @param targetURL The destination URL for the POST request.
     * @param urlParameters The body of the POST request.
     * @return The response received from the HTTP request.
     */
    public static String executePost(String targetURL, String urlParameters) {
        HttpURLConnection connection = null;
        try {
            URL url = new URL(targetURL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Content-Length", Integer.toString(urlParameters.getBytes().length));

            //connection.setUseCaches(false);
            connection.setDoOutput(true);

            //Send request
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.close();

            //Get Response
            return getHttpResponseMessage(connection);
        } catch (MalformedURLException e) {
            return "URL Error: " + e.getMessage() + ", " + e.getClass().toString();
        } catch (IOException e) {
            return "IO Error: " + e.getMessage() + ", " + e.getClass().toString();
        }
    }

    /**
     * Console command: log into a user account.
     * @param userName The username for the login.
     * @param password The password for the login.
     */
    public void execLogin(String userName, String password) {
        String result = executePost(urlPrefix + "/home/login",
                "{\"email\": \"" + userName + "\", \"password\": \"" + password + "\"}");
        System.out.println(result);
    }

    /**
     * Console command: create a user account
     * @param firstName New account's first name.
     * @param lastName New account's last name.
     * @param email The e-mail address for the account.
     * @param password The password for the new account.
     * @param role One of the four recognized roles.
     */
    public void execAccount(String firstName, String lastName, String email, String password, String role) {
        String result = executePost(urlPrefix + "/admin/account",
                "{\"firstName\": \"" + firstName + "\", \"lastName\": \"" + lastName + "\", \"email\": \"" + email + "\", \"password\": \"" + password + "\", \"role\": \"" + role + "\"}");
        System.out.println(result);
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the VAXSYS User Console!");
        VaxsysUserConsole userConsole = new VaxsysUserConsole();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter a valid command, or type \"EXIT\" to quit!");
        // Read input, and keep reading until "EXIT" or "QUIT" is entered.
        String userInput = keyboard.nextLine();
        while (!userInput.equalsIgnoreCase("EXIT")) {
            String[] splitInput = userInput.split(" ");
            boolean validCommandFound = false;
            if (splitInput.length > 0) {
                int numParams = splitInput.length - 1;
                // Attempt to match
                for (Method method : userConsole.execMethods) {
                    if (method.getName().equalsIgnoreCase("exec" + splitInput[0])
                            && method.getParameterCount() == numParams) {
                        LinkedList<Object> parameters = new LinkedList<>();
                        for (int i = 1; i <= numParams; i++) {
                            parameters.add(splitInput[i]);
                        }
                        try {
                            method.invoke(userConsole, parameters.toArray());
                            validCommandFound = true;
                        } catch (InvocationTargetException | IllegalAccessException e ) {
                            System.out.println("Error executing command: " + splitInput[0]);
                        }
                    }
                }
            }
            if (!validCommandFound) {
                System.out.println("Please enter a valid command.");
            }
            // Get next input.
            userInput = keyboard.nextLine();
        }
        System.out.println("Thank you for using the VAXSYS User Console!");
    }
}
