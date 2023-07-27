    
    class Car {
        private int speed;       // Speed in km/h
        private String direction; // Direction: "N" (North), "S" (South), "E" (East), "W" (West)
    
        public Car(int speed, String direction) {
            this.speed = speed;
            this.direction = direction;
        }
    
        public int getSpeed() {
            return speed;
        }
    
        public void accelerate(int amount) {
            speed += amount;
        }
    
        public void brake(int amount) {
            speed = Math.max(0, speed - amount);
        }
    
        public String getDirection() {
            return direction;
        }
    }
    
    class TrafficLight {
        private boolean isGreen;
    
        public TrafficLight() {
            isGreen = false; // Initialize traffic light to red
        }
    
        public boolean isGreen() {
            return isGreen;
        }
    
        public void setGreen(boolean isGreen) {
            this.isGreen = isGreen;
        }
    }
    
    
    
    import java.util.Random;
    
    public class IntersectionSimulator {
        private static final int SIMULATION_TIME_SECONDS = 60;
    
        public static void main(String[] args) {
            TrafficLight trafficLight = new TrafficLight();
            Random rand = new Random();
    
            // Create cars with random speeds and directions
            Car[] cars = new Car[20];
            for (int i = 0; i < cars.length; i++) {
                int speed = rand.nextInt(60) + 20; // Speed between 20 and 80 km/h
                String[] directions = {"N", "S", "E", "W"};
                String direction = directions[rand.nextInt(directions.length)];
                cars[i] = new Car(speed, direction);
            }
    
            // Simulate the intersection for a fixed number of seconds
            for (int time = 0; time < SIMULATION_TIME_SECONDS; time++) {
                System.out.println("Time: " + time + " seconds");
    
                // Randomly set the traffic light to green for one direction
                int randomDirectionIndex = rand.nextInt(4);
                String[] directions = {"N", "S", "E", "W"};
                String greenDirection = directions[randomDirectionIndex];
                System.out.println("Traffic light is green for: " + greenDirection);
                trafficLight.setGreen(true);
    
                // Simulate car movements and update traffic light
                for (Car car : cars) {
                    if (car.getDirection().equals(greenDirection)) {
                        System.out.println("Car going " + car.getDirection() + " with speed " + car.getSpeed() + " km/h");
                    } else {
                        System.out.println("Car waiting at red light: " + car.getDirection());
                    }
                }
    
                trafficLight.setGreen(false); // Set the traffic light back to red
                System.out.println("------------------");
    
                try {
                    Thread.sleep(1000); // Wait for 1 second in the simulation
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
