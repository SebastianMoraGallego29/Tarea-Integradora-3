package model;

import java.util.Random;

public abstract class Document {

    private Random r;
    private double documentPrice;
    private int documentYear;
    private int[][] image;
    private String code;
   
    public Document(double documentPrice, int documentYear) {
        this.setDocumentPrice(documentPrice);
        this.setDocumentYear(documentYear);
        image = new int[4][4];
    }

    public double getDocumentPrice() {
        return documentPrice;
    }

    public void setDocumentPrice(double documentPrice) {
        this.documentPrice = documentPrice;
    }

    public int getDocumentYear() {
        return documentYear;
    }

    public void setDocumentYear(int documentYear) {
        this.documentYear = documentYear;
    }

    public int[][] getImage() {
        return image;
    }

    public void setImage(int[][] image) {
        this.image = image;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int[][] generateImage() {

        r = new Random();

        int[][] image = new int[4][4];

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				image[i][j] = r.nextInt(11);
			}
		}

        return image;

    }

    /*
    @Override
    public String showDocumentStatus() {

        String msg = "";

        return msg;
    }
    */
    
    @Override
    public String toString() {
        return "Document [documentPrice=" + documentPrice + ", documentYear=" + documentYear + "]";
    }

}
