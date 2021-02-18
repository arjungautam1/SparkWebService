/**
 * @author : Arjun Gautam
 * e-mail : arjungautam5431@gmail.com
 * Date :2021-02-18
 * Time :10:40
 */
package controller;

import com.google.gson.Gson;
import model.User;
import service.UserServiceImpl;
import status.StandardResponse;
import status.StatusResponse;

import static spark.Spark.*;

public class SparkREST {
    public static void main(String[] args) {
        final UserServiceImpl userService = new UserServiceImpl();

        /* Add user */
        post("/users", (request, response) -> {
            response.type("application/json");
            User user = new Gson().fromJson(request.body(), User.class);

            userService.addUser(user);
            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS));
        });
    }
}
