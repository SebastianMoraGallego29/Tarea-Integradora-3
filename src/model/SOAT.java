package model;

public class SOAT extends Document {

    private double accidentR;

    public SOAT(double documentPrice, int documentYear, double accidentR) {
        super(documentPrice, documentYear);
        this.setAccidentR(accidentR);
        setImage(generateImage());
        setCode(generateCode());
    }

    public double getAccidentR() {
        return accidentR;
    }

    public void setAccidentR(double accidentR) {
        this.accidentR = accidentR;
    }

    public String generateCode() {

		String code = "";

        int i = 0;

		for (int j = 0; j <= getImage().length; j++) {
            code += getImage()[i][j];
            if (j == getImage().length) {
                for (i = 3; j  <= getImage().length; j--) {
                    code += getImage()[i][j];
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

    /*
    @Override
    public String showDocumentStatus() {

        String msg = "";

        msg += generateCode();

        return msg;

    }
    */
    
    @Override
    public String toString() {
        return " " + getDocumentPrice() + " " + getDocumentYear() + " " + accidentR + " " + printImage(getImage()) + " " + getCode();
    }

}
