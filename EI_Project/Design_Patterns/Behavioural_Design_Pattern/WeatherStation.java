import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Subject (Weather Station)
class WeatherStation {
    private List<Display> observers;
    private double temperature;
    private double humidity;
    private double windSpeed;

    public WeatherStation() {
        this.observers = new ArrayList<>();
        this.temperature = 0;
        this.humidity = 0;
        this.windSpeed = 0;
    }

    public void registerObserver(Display observer) {
        observers.add(observer);
    }

    public void removeObserver(Display observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Display observer : observers) {
            observer.update(temperature, humidity, windSpeed);
        }
    }

    public void setMeasurements(double temperature, double humidity, double windSpeed) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        notifyObservers();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        WeatherStation weatherStation = new WeatherStation();
        MobileApp mobileApp = new MobileApp();
        Website website = new Website();

        weatherStation.registerObserver(mobileApp);
        weatherStation.registerObserver(website);

        while (true) {
            System.out.println("Enter temperature (or -1 to exit): ");
            double temperature = scanner.nextDouble();
            if (temperature == -1) {
                break;
            }

            System.out.println("Enter humidity: ");
            double humidity = scanner.nextDouble();

            System.out.println("Enter wind speed: ");
            double windSpeed = scanner.nextDouble();

            weatherStation.setMeasurements(temperature, humidity, windSpeed);
        }

        scanner.close();
    }
}

// Observer (Display)
interface Display {
    void update(double temperature, double humidity, double windSpeed);
}

class MobileApp implements Display {
    @Override
    public void update(double temperature, double humidity, double windSpeed) {
        System.out.println("Mobile App: Temperature=" + temperature + ", Humidity=" + humidity + ", Wind Speed=" + windSpeed);
    }
}

class Website implements Display {
    @Override
    public void update(double temperature, double humidity, double windSpeed) {
        System.out.println("Website: Temperature=" + temperature + ", Humidity=" + humidity + ", Wind Speed=" + windSpeed);
    }
}