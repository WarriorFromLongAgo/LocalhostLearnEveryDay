package com.byit.model;

public class DemoStructure {
    public class OverLoad {
        String uniqueID;

        public int AddNum(int a, int b) {
            return a + b;
        }

        public double AddNum(int a, double b) {
            return a + b;
        }

        public void setUniquqeID(String TheID) {
            uniqueID = TheID;
        }

        public void setUniquqeID(int ssNumber) {
            String numString = "" + ssNumber;
            setUniquqeID(numString);
        }
    }
}
