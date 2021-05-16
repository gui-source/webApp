package uk.ac.ucl.model;

import java.io.File;
import java.io.IOException;

public class ModelFactory
{
    private static Model model;

    public static Model getModel(String fileName) {
        if (model == null) {
            model = new Model();
        }
        try {
            model.readFile(fileName);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }
}
