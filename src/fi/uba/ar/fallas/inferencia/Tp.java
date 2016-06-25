package fi.uba.ar.fallas.inferencia;

import org.drools.RuleBase;
import org.drools.RuleBaseFactory;
import org.drools.WorkingMemory;
import org.drools.compiler.DroolsError;
import org.drools.compiler.DroolsParserException;
import org.drools.compiler.PackageBuilder;
import org.drools.compiler.PackageBuilderErrors;
import org.drools.rule.Package;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class Tp {

    public static void main(String[] args) {
        Runner r = new Runner();
        RuleBase ruleBase = null;
        try {
            ruleBase = r.initialiseDrools();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DroolsParserException e) {
            e.printStackTrace();
        }
        WorkingMemory workingMemory = r.initializeMessageObjects(ruleBase);
        int expectedNumberOfRulesFired = 1;

        int actualNumberOfRulesFired = workingMemory.fireAllRules();

        System.out.print(actualNumberOfRulesFired);
    }
}
