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

        /* Get User */
        get("/users", (request, response) -> {
            response.type("application/json");
            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(userService.getUsers())));
        });

        /* Get User */
        get("/user/:id", (request, response) -> {
            response.type("application/json");
            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(userService.getUser(request.params(":id")))));
        });

        /* Edit User */
        put("/users/:id", (request, response) -> {
            response.type("application/json");

            User toEdit = new Gson().fromJson(request.body(), User.class);
            User editedUser = userService.editUser(toEdit);

            if (editedUser != null) {
                return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(editedUser)));
            } else {
                return new Gson().toJson(new StandardResponse(StatusResponse.ERROR, new Gson().toJsonTree("User not Found or error in edit")));
            }
        });

        /* For Delete User */
        delete("/users/:id", (request, response) -> {
            response.type("application/json");
            userService.deleteUser(request.params(":id"));
            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, "User Deleted"));
        });

        options("/users/:id", (request, response) -> {
            response.type("application/json");

            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, (userService.userExist(request.params(":id"))) ? "User Exists" : "User does not exist"));
        });


    }
}
