package fi.uba.ar.fallas.inferencia;

import org.drools.RuleBase;
import org.drools.WorkingMemory;
import org.drools.compiler.DroolsParserException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Scanner;

public class Tp {

    public static void main(String[] args) {

        Runner r = new Runner();
        Mole mole = new Mole("");
        mole.setShape("Simetrica");
        mole.setBorder("Regular");
        mole.setDiameter(true);
        mole.setItch(false);
        mole.setRelieve(false);
        mole.setSolarExposure(true);
        mole.setChanges(false);
        mole.setColor("Variado");
        RuleBase ruleBase = null;
        try {
            ruleBase = r.initialiseDrools();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DroolsParserException e) {
            e.printStackTrace();
        }
        r.setMole(mole);
        WorkingMemory workingMemory;

        System.out.print("Ingrese la cantidad de lunares a evaluar:");
        int number = getNumber();

        for (int i = number; i < 5; i++) {
            setMoleShape(mole);
            setMoleBorder(mole);
            setMoleColor(mole);

            setMoleDiameter(mole);
            setMoleRelieve(mole);
            setMoleChanges(mole);
            setMoleItch(mole);
            setMoleSExposion(mole);

            String name = String.format(Locale.ENGLISH, "Lunar %d", i);
            mole.setMolename(name);
            workingMemory = r.initializeMessageObjects(ruleBase);
            int actualNumberOfRulesFired = workingMemory.fireAllRules();
            if (actualNumberOfRulesFired < 1) {
                mole.showDiagnoses("Lunar sin diagnostico");
            }
        }
    }

    private static int getNumber() {
        while (true) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                String input = bufferedReader.readLine();
                return Integer.parseInt(input);
            } catch (NumberFormatException ex) {
                System.out.println("No es un numero valido!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void setMoleShape(Mole mole) {
        String option;
        option = getOption("El lunar presenta:\n\t1) Forma Asimetrica\n\t2) Forma Simetrica");
        if (option.equals("1")) {
            mole.setShape("Asimetrica");
        }
        if (option.equals("2")) {
            mole.setShape("Simetrica");
        }
    }

    private static void setMoleBorder(Mole mole) {
        String option;
        option = getOption("El lunar presenta:\n\t1) Borde regular\n\t2) Borde irregular");
        if (option.equals("1")) {
            mole.setBorder("Regular");
        }
        if (option.equals("2")) {
            mole.setBorder("Irregular");
        }
    }

    private static void setMoleDiameter(Mole mole) {
        boolean option;
        option = getBoolOption("El lunar tiene un diametro menor a 7mm? [S/N]:");
        mole.setDiameter(option);
    }

    private static void setMoleRelieve(Mole mole) {
        boolean option;
        option = getBoolOption("El lunar tiene relieve? [S/N]:");
        mole.setRelieve(option);
    }

    private static void setMoleChanges(Mole mole) {
        boolean option;
        option = getBoolOption("El lunar presento alteraciones en el ultimo mes? [S/N]:");
        mole.setChanges(option);
    }

    private static void setMoleSExposion(Mole mole) {
        boolean option;
        option = getBoolOption("El lunar fue expuesto al sol ultimamente? [S/N]:");
        mole.setSolarExposure(option);
    }

    private static void setMoleItch(Mole mole) {
        boolean option;
        option = getBoolOption("El lunar genera comezon? [S/N]:");
        mole.setItch(option);
    }


    private static void setMoleColor(Mole mole) {
        String option;
        option = getOption("El lunar tiene:\n\t1) Color unico\n\t2) Color variado");
        if (option.equals("1")) {
            mole.setColor("Unico");
        }
        if (option.equals("2")) {
            mole.setColor("Variado");
        }
    }

    private static String getOption(String message) {
        String option;
        System.out.println(message);
        Scanner in = new Scanner(System.in);
        option = in.nextLine();
        while (!option.equals("1") && !option.equals("2")) {
            System.out.println("No es una opcion valida. Por favor ingrese '1' o '2'");
            option = in.nextLine();
        }
        return option;
    }

    private static Boolean getBoolOption(String message) {
        String option;
        System.out.print(message);
        Scanner in = new Scanner(System.in);
        option = in.nextLine();
        while (!option.equals("S") && !option.equals("N")) {
            System.out.println("No es una opcion valida. Por favor ingrese 'S' o 'N'");
            option = in.nextLine();
        }
        return option.equals("S");
    }
}
