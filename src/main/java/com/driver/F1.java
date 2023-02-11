package com.driver;

public class F1 extends Car {
    private boolean isManual;
    private String name;
    public F1(String name, boolean isManual) {
        //Use arbitrary values for parameters which are not mentioned
        this.isManual = isManual;
        this.name = name;
    }

    public void accelerate(int rate){
        int newSpeed = 0; //set the value of new speed by using currentSpeed and rate
        /**
         * speed 0: gear 1
         * speed 1-50: gear 1
         * speed 51-100: gear 2
         * speed 101-150: gear 3
         * speed 151-200: gear 4
         * speed 201-250: gear 5
         * speed more than 250: gear 6
         */
        newSpeed += getCurrentSpeed() + rate;

        if(newSpeed == 0) {
            //Stop the car, set gear as 1
            stop();
            changeGear(1);
        }
        //for all other cases, change the gear accordingly

        if(newSpeed > 0) {
            changeSpeed(newSpeed, getCurrentDirection());
            if(1<=newSpeed && newSpeed<=50){
                changeGear(1);
            }
            else if(51<=newSpeed && newSpeed<=100){
                changeGear(2);
            }
            else if(101<=newSpeed && newSpeed<=150){
                changeGear(3);
            }
            else if(151<=newSpeed && newSpeed<=200){
                changeGear(4);
            }
            else if(201<=newSpeed && newSpeed<=250){
                changeGear(5);
            }
            else{
                changeGear(6);
            }
        }
    }
}
