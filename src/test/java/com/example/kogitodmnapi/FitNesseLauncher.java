package com.example.kogitodmnapi;

import com.example.kogitodmnapi.config.SpringFitNesseRunner;
import fitnesse.junit.FitNesseRunner;
import org.junit.runner.RunWith;

@RunWith(SpringFitNesseRunner.class)
@FitNesseRunner.Suite("LoanApprovalSuite")
@FitNesseRunner.FitnesseDir("src/test/fitnesse")
@FitNesseRunner.OutputDir("target/fitnesse-results")
public class FitNesseLauncher {
    public static void main(String[] args) throws Exception {
        fitnesse.Main.main(new String[]{"-p", "8090", "-d", "src/test/fitnesse"});
    }
}

