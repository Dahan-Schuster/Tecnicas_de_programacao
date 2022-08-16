
public class Heater
{
    private int temperature;
    private int max;
    private int min;
    private int increment;
    
    static final int baseTemperature = 15;
    static final int temperatureStep = 5;

    public Heater(int min, int max)
    {
        if (max < min) {
            int aux = min;
            min = max;
            max = aux;
            
            System.out.println("Max should be greater than Min. The values were swaped to maintain cohesion.");
        }
            
        this.max = max;
        this.min = min;
        increment = Heater.temperatureStep;
        temperature = Heater.baseTemperature;
    }

    public void warmer()
    {
        if (temperature + increment > max)
            System.out.println("Temperature is already at the max value of " + max + "ºC");
        else
            temperature += increment;
    }
    
    public void cooler()
    {
        if (temperature - increment < min)
            System.out.println("Temperature is already at the min value of " + min + "ºC");
        else
            temperature -= increment;
    }
    
    public int getTemperature()
    {
        return temperature;
    }
}
