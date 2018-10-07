package com.example.saraa.mylocker;

public class savedata {


        int lockernumber1, buildingnum, floornum;
        String ssize;


        String status;

        public savedata(int lockernumber1, int buildingnum, int floornum, String ssize, String status) {
            this.lockernumber1 = lockernumber1;
            this.buildingnum = buildingnum;
            this.floornum = floornum;
            this.ssize = ssize;
            this.status = status;
        }

        public int getLockernumber1() {
            return lockernumber1;
        }

        public int getBuildingnum() {
            return buildingnum;
        }

        public int getFloornum() {
            return floornum;
        }

        public String getSsize() {
            return ssize;
        }

        public String getStatus() {
            return status;
        }
    }
