package pho.advcode2024;

import pho.advcode2024.core.ContentLoader;
import pho.advcode2024.day1.Library;
import pho.advcode2024.day2.ReportManager;

import java.io.IOException;

public class Answers {

    public static void main(String[] args) throws IOException {
        // Day 2
        ReportManager reportManager = new ReportManager(ContentLoader.load("inputs/day02.txt"));

        long reportMenagerPart1 = reportManager.countSafeReports();
        long reportMenagerPart2 = 0;

        System.out.printf("""
            Challenge 2:
            
            First part...: %d
            Second part..: %d
            
            ==============================
            """, reportMenagerPart1, reportMenagerPart2);
    }

}
