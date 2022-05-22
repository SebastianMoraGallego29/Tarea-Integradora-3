package model;

public class PropertyCard extends Document {

    public PropertyCard(double documentPrice, int documentYear) {
        super(documentPrice, documentYear);
        setImage(generateImage());
        setCode(generateCode());
    }

    public String generateCode() {

        String code = "";

        int i = 0;

        for (int j = 0; j <= getImage().length; j++) {
            code += getImage()[i][j];
            if (j == getImage().length) {
                for (i = 0; j <= getImage().length; j--) {
                    code += getImage()[i][j];
                    i--;
                    if (j == 0) {
                        if (i == 3) {
                            for (j = 0; j <= getImage().length; j++) {
                                code += getImage()[i][j];
                            }
                        }
                    }
                }
            }
        }

        return code;

    }

    public String printImage(int[][] image) {
        String print = "";
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                print += image[i][j] + " ";
            }
            print += "\n";
        }
        return print;
    }

}
