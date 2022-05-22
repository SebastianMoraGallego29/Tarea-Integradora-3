package model;

import java.util.ArrayList;

public class VehicleDealerController {

    private ArrayList<Vehicle> vehicle;

    public VehicleDealerController() {

        setVehicle(new ArrayList<>());

    }

    public ArrayList<Vehicle> getVehicle() {
        return vehicle;
    }

    public void setVehicle(ArrayList<Vehicle> vehicle) {
        this.vehicle = vehicle;
    }

    /**
     * <pre>
     * <strong>Descripción del método </strong> El metodo registerGasolineCar permite crear un Carro a Gasolina.
     * 
     * <strong>Inputs:</strong> double basePrice, double discount, String brand, String model,
            double cylinderCapacity, double mileage,
            int status, String plate, int automobileType, int doors, boolean windowsT, double tankCapacity,
            int gasolineType <strong>
     * Outputs:</strong> El método retorna un booleano, el cual, si es verdadero indica que el objeto se creó correctamente o falso si no.
     * </pre>
     */
    public boolean registerGasolineCar(double basePrice, double discount, String brand, String model,
            double cylinderCapacity, double mileage,
            int status, String plate, int automobileType, int doors, boolean windowsT, double tankCapacity,
            int gasolineType) {

        return vehicle.add(new GasolineCar(basePrice, discount, brand, model, cylinderCapacity, mileage, status, plate,
                automobileType, doors, windowsT, tankCapacity, gasolineType));

    }

    /**
     * <pre>
     * <strong>Descripción del método </strong> El metodo registerElectricCar permite crear un Carro Eléctrico.
     * 
     * <strong>Inputs:</strong> double basePrice, double discount, String brand, String model,
            double cylinderCapacity, double mileage,
            int status, String plate, int automobileType, int doors, boolean windowsT, int chargerType,
            double batteryLife <strong>
     * Outputs:</strong> El método retorna un booleano, el cual, si es verdadero indica que el objeto se creó correctamente o falso si no.
     * </pre>
     */
    public boolean registerElectricCar(double basePrice, double discount, String brand, String model,
            double cylinderCapacity, double mileage,
            int status, String plate, int automobileType, int doors, boolean windowsT, int chargerType,
            double batteryLife) {

        return vehicle.add(new ElectricCar(basePrice, discount, brand, model, cylinderCapacity, mileage, status, plate,
                automobileType, doors, windowsT, chargerType, batteryLife));

    }

    /**
     * <pre>
     * <strong>Descripción del método </strong> El metodo registerHybridCar permite crear un Carro Híbrido.
     * 
     * <strong>Inputs:</strong> double basePrice, double discount, String brand, String model,
            double cylinderCapacity, double mileage,
            int status, String plate, int automobileType, int doors, boolean windowsT, double tankCapacity,
            int gasolineType, int chargerType, double batteryLife <strong>
     * Outputs:</strong> El método retorna un booleano, el cual, si es verdadero indica que el objeto se creó correctamente o falso si no.
     * </pre>
     */
    public boolean registerHybridCar(double basePrice, double discount, String brand, String model,
            double cylinderCapacity, double mileage,
            int status, String plate, int automobileType, int doors, boolean windowsT, double tankCapacity,
            int gasolineType, int chargerType, double batteryLife) {

        return vehicle.add(new HybridCar(basePrice, discount, brand, model, cylinderCapacity, mileage, status, plate,
                automobileType, doors, windowsT, tankCapacity, gasolineType, chargerType, batteryLife));

    }

    /**
     * <pre>
     * <strong>Descripción del método </strong> El metodo registerMotorCycle permite crear una Moto.
     * 
     * <strong>Inputs:</strong> double basePrice, double discount, String brand, String model,
            double cylinderCapacity, double mileage,
            int status, String plate, int motorcycleType, double gasolineCapacity <strong>
     * Outputs:</strong> El método retorna un booleano, el cual, si es verdadero indica que el objeto se creó correctamente o falso si no.
     * </pre>
     */
    public boolean registerMotorCycle(double basePrice, double discount, String brand, String model,
            double cylinderCapacity, double mileage,
            int status, String plate, int motorcycleType, double gasolineCapacity) {

        return vehicle.add(new Motorcycle(basePrice, discount, brand, model, cylinderCapacity, mileage, status, plate,
                motorcycleType, gasolineCapacity));

    }

    /**
     * <pre>
     * <strong>Descripción del método </strong> El metodo registerDocument permite crear un Documento.
     * 
     * <strong>Inputs:</strong> int vehicleN, int documentType, double documentPrice, int documentYear,
            double accidentR, double gasesE <strong>
     * Outputs:</strong> El método retorna un booleano, el cual, si es verdadero indica que el objeto se creó correctamente o falso si no.
     * </pre>
     */
    public boolean registerDocument(int vehicleN, int documentType, double documentPrice, int documentYear,
            double accidentR, double gasesE) {

        return vehicle.get(vehicleN - 1).registerDocument(vehicleN, documentType, documentPrice, documentYear,
                accidentR, gasesE);

    }

    /**
     * <pre>
     * <strong>Descripción del método </strong> El metodo calculateSalePrice permite mostrar el cálculo del precio total de venta de un vehículo.
     * 
     * <strong>Inputs:</strong> int vehicleN <strong>
     * Outputs:</strong> El método retorna un String, el cual, contiene un mensaje que muestra el precio total de venta un vehículo.
     * </pre>
     */
    public String calculateSalePrices(int vehicleN) {

        String msg = "The total sale price is: ";

        msg += vehicle.get(vehicleN - 1).calculateSalePrice();

        return msg;

    }

    /**
     * <pre>
     * <strong>Descripción del método </strong> El metodo showVehicleList permite mostrar una lista con los vehículos registrados hasta el momento.
     * 
     * <strong>Inputs:</strong> <strong>
     * Outputs:</strong> El método retorna un String, mostrando la lista de los vehículos registrados hasta el momento mostrando dos atributos de este, la marca y el modelo..
     * </pre>
     */
    public String showVehicleList() {

        String msg = "";

        for (int i = 0; i < vehicle.size(); i++) {

            msg += "\n" + (i + 1) + ". Brand: " + vehicle.get(i).getBrand() + " Model: " + vehicle.get(i).getModel();

        }

        return msg;

    }

    /**
     * <pre>
     * <strong>Descripción del método </strong> El metodo showbyVehicleType permite mostrar una lista con los vehículos registrados hasta el momento organizados por tipo de Vehículo.
     * 
     * <strong>Inputs:</strong> <strong>
     * Outputs:</strong> El método retorna un String, mostrando la lista de los vehículos registrados hasta el momento mostrando organizados por tipo de Vehículo (Carros y Motos)
     * </pre>
     */
    public String showbyVehicleType() {

        String msg = "";

        for (int i = 0; i < vehicle.size(); i++) {

            if (vehicle.get(i) instanceof Motorcycle) {

                msg += "Motorcycles:\n" + vehicle.get(i).toString();

            }

        }

        for (int i = 0; i < vehicle.size(); i++) {

            if (vehicle.get(i) instanceof GasolineCar || vehicle.get(i) instanceof ElectricCar
                    || vehicle.get(i) instanceof HybridCar) {

                msg += "Cars:\n" + vehicle.get(i).toString();

            }

        }

        return msg;

    }

    /**
     * <pre>
     * <strong>Descripción del método </strong> El metodo showbyGasolineType permite mostrar una lista con los vehículos registrados hasta el momento organizados por tipo de Gasolina.
     * 
     * <strong>Inputs:</strong> <strong>
     * Outputs:</strong> El método retorna un String, mostrando la lista de los vehículos registrados hasta el momento mostrando organizados por tipo de Gasolina (Diesel, Extra y Regular)
     * </pre>
     */
    public String showbyGasolineType() {

        String msg = "";

        for (int i = 0; i < vehicle.size(); i++) {

            if (((GasolineCar) vehicle.get(i)).getGasolineType().equals(GasolineType.DIESEL)) {

                msg += "Diesel Gasoline Cars:\n" + vehicle.get(i).toString();

            }

        }

        for (int i = 0; i < vehicle.size(); i++) {

            if (((GasolineCar) vehicle.get(i)).getGasolineType().equals(GasolineType.EXTRA) || ((HybridCar) vehicle.get(i)).getGasolineType().equals(GasolineType.EXTRA)) {

                msg += "Extra Gasoline Cars:\n" + vehicle.get(i).toString();

            }
            
        }

        for (int i = 0; i < vehicle.size(); i++) {

            if (((GasolineCar) vehicle.get(i)).getGasolineType().equals(GasolineType.REGULAR) || ((HybridCar) vehicle.get(i)).getGasolineType().equals(GasolineType.REGULAR)) {

                msg += "Regular Gasoline Cars:\n" + vehicle.get(i).toString();

            }
            
        }

        return msg;

    }

    /**
     * <pre>
     * <strong>Descripción del método </strong> El metodo showbyAutomobileStatus permite mostrar una lista con los vehículos registrados hasta el momento organizados por su estado.
     * 
     * <strong>Inputs:</strong> <strong>
     * Outputs:</strong> El método retorna un String, mostrando la lista de los vehículos registrados hasta el momento mostrando organizados por su estado (Nuevos y Usados)
     * </pre>
     */
    public String showbyAutomobileStatus() {

        String msg = "";

        for (int i = 0; i < vehicle.size(); i++) {

            if (vehicle.get(i).getStatus().equals(VehicleStatus.NEW)) {

                msg += "New Vehicles:\n" + vehicle.get(i).toString();

            }

        }

        for (int i = 0; i < vehicle.size(); i++) {

            if (vehicle.get(i).getStatus().equals(VehicleStatus.USED)) {

                msg += "Used Vehicles:\n" + vehicle.get(i).toString();

            }

        }

        return msg;

    }

    /*
    public String showDocumentStatus(int vehicleN) {

        String msg = "The total sale price is: ";

        msg += vehicle.get(vehicleN - 1).showDocumentStatus();

        return msg;

    }
    */

}
