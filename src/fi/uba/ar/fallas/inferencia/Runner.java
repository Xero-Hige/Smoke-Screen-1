package fi.uba.ar.fallas.inferencia;

import org.drools.RuleBase;
import org.drools.RuleBaseFactory;
import org.drools.WorkingMemory;
import org.drools.compiler.DroolsError;
import org.drools.compiler.DroolsParserException;
import org.drools.compiler.PackageBuilder;
import org.drools.compiler.PackageBuilderErrors;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class Runner {

    public RuleBase initialiseDrools() throws IOException, DroolsParserException {
        PackageBuilder packageBuilder = readRuleFiles();
        return addRulesToWorkingMemory(packageBuilder);
    }

    private PackageBuilder readRuleFiles() throws DroolsParserException, IOException {
        PackageBuilder packageBuilder = new PackageBuilder();

        String ruleFile = "rules.drl";
        Reader reader = getRuleFileAsReader(ruleFile);
        packageBuilder.addPackageFromDrl(reader);

        assertNoRuleErrors(packageBuilder);

        return packageBuilder;
    }

    private Reader getRuleFileAsReader(String ruleFile) {
        InputStream resourceAsStream = getClass().getResourceAsStream(ruleFile);
        return new InputStreamReader(resourceAsStream);
    }

    private RuleBase addRulesToWorkingMemory(PackageBuilder packageBuilder) {
        RuleBase ruleBase = RuleBaseFactory.newRuleBase();
        org.drools.rule.Package rulesPackage = packageBuilder.getPackage();
        ruleBase.addPackage(rulesPackage);

        return ruleBase;
    }

    private void assertNoRuleErrors(PackageBuilder packageBuilder) {
        PackageBuilderErrors errors = packageBuilder.getErrors();

        if (errors.getErrors().length > 0) {
            StringBuilder errorMessages = new StringBuilder();
            errorMessages.append("Found errors in package builder\n");
            for (int i = 0; i < errors.getErrors().length; i++) {
                DroolsError errorMessage = errors.getErrors()[i];
                errorMessages.append(errorMessage);
                errorMessages.append("\n");
            }
            errorMessages.append("Could not parse knowledge");

            throw new IllegalArgumentException(errorMessages.toString());
        }
    }

    public WorkingMemory initializeMessageObjects(RuleBase ruleBase) {
        WorkingMemory workingMemory = ruleBase.newStatefulSession();

        createEngine(workingMemory);

        return workingMemory;
    }

    private void createEngine(WorkingMemory workingMemory) {
        Mole mole = new Mole("Lunar 1");
        mole.setShape("Simetrica");
        mole.setBorder("Regular");
        mole.setDiameter(true);
        mole.setItch(false);
        mole.setRelieve(false);
        mole.setSolarExposure(true);
        mole.setChanges(false);
        mole.setColor("Variado");
        workingMemory.insert(mole);


        mole = new Mole("Lunar 2");
        mole.setShape("Asimetrica");
        mole.setBorder("Irregular");
        mole.setDiameter(true);
        mole.setItch(false);
        mole.setRelieve(false);
        mole.setSolarExposure(true);
        mole.setChanges(true);
        mole.setColor("Variado");
        workingMemory.insert(mole);

        mole = new Mole("Lunar 3");
        mole.setShape("Asimetrica");
        mole.setBorder("Regular");
        mole.setDiameter(false);
        mole.setItch(false);
        mole.setRelieve(true);
        mole.setSolarExposure(true);
        mole.setChanges(true);
        mole.setColor("Variado");
        workingMemory.insert(mole);

        mole = new Mole("Lunar 4");
        mole.setShape("Asimetrica");
        mole.setBorder("Irregular");
        mole.setDiameter(false);
        mole.setItch(false);
        mole.setRelieve(true);
        mole.setSolarExposure(false);
        mole.setChanges(true);
        mole.setColor("Variado");
        workingMemory.insert(mole);
    }

}


