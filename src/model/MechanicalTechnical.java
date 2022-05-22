package model;

public class MechanicalTechnical extends Document {

    private double gasesE;
    
    public MechanicalTechnical(double documentPrice, int documentYear, double gasesE) {
        super(documentPrice, documentYear);
        this.gasesE = gasesE;
        setImage(generateImage());
        //setCode(generateCode());
    }

    public double getGasesE() {
        return gasesE;
    }

    public void setGasesE(double gasesE) {
        this.gasesE = gasesE;
    }

    /*
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
    */

}
