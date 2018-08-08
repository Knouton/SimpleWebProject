package app.model;

import app.entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Model {
        private static Model instance = new Model();
        private List<User> model;

        public static Model getInstance() {
            return instance;
        }
    private Model() {
        model = new ArrayList<>();
    }

    public void add(User user) {
        model.add(user);
        }

    public void remove(String name) {
        for (int i = 0; i < model.size(); i++) {
            if (model.get(i).getName().equals(name)){
                model.remove(model.get(i));
            }
        }
    }

    public List<String> list() {
        return model.stream()
                .map(User::getName)
                .collect(Collectors.toList());
    }
}
