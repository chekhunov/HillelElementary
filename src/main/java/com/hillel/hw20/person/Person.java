package com.hillel.hw20.person;

    public abstract class Person extends Entity {
        private String fullName;
        private int dateOfBirth;


        public Person(int id, String fullName, int dateOfBirth) {
            super(id);
            this.fullName = fullName;
            this.dateOfBirth = dateOfBirth;
        }

        public Person(String fullName) {
            this.fullName = fullName;

        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public int getDateOfBirth() {
            return dateOfBirth;
        }

        public void setDateOfBirth(int dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }

        @Override
        public String toString() {
            return "Person " +
                    "fullName = '" + fullName + '\'' ;
        }
    }

