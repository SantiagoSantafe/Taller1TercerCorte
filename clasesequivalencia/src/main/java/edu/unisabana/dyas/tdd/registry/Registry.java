package edu.unisabana.dyas.tdd.registry;

import java.util.HashSet;

public class Registry {
    private HashSet<Integer> idsRegistrados = new HashSet<>();

    public RegisterResult registerVoter(Person p) {
        try{
            if (p.getName() == null || p.getName().isEmpty() ||
                p.getId() == 0 ||
                p.getGender() == null) {
                return RegisterResult.INVALID_DATA;
            }
            if (p.getName() == null || p.getName().isEmpty() ||
            !p.getName().matches("[a-zA-Z ]+")) {
                return RegisterResult.INVALID_DATA;
            }
            if (!p.isAlive()) {
                return RegisterResult.DEAD;
            }
            if (p.getAge() < 0) {
                return RegisterResult.INVALID_AGE;
            }
            if (p.getAge() < 18) {
                return RegisterResult.UNDERAGE;
            }
            if (idsRegistrados.contains(p.getId())) {
                return RegisterResult.DUPLICATED;
            }
            idsRegistrados.add(p.getId());
            return RegisterResult.VALID;
        }catch(Exception e){
            return RegisterResult.INVALID_DATA;
        }
    }

    
}
