package com.test.datasim.app.util;

import com.test.data.model.CustProfile;
import com.test.datasim.app.CustProfileRepository;
import com.test.datasim.generators.alphanumeric.Patterns;
import com.test.datasim.generators.alphanumeric.StringGenerator;
import com.test.datasim.generators.alphanumeric.StringGeneratorWithPattern;
import com.test.datasim.generators.timestamp.DateTimeGenerator;

public class CustProfileDataGenerator {

    private StringGenerator stringGenerator;
    private StringGeneratorWithPattern panGenerator;
    private StringGeneratorWithPattern passportNoGenerator;
    private DateTimeGenerator dateTimeGenerator;

    private long count;

    public CustProfileDataGenerator(long count){
        this.count = count;
        this.stringGenerator = new StringGenerator(10);
        this.panGenerator =
                new StringGeneratorWithPattern(Patterns.PAN_IN, true);
        this.passportNoGenerator =
                new StringGeneratorWithPattern(Patterns.PASSPORT_IN, true);
        this.dateTimeGenerator =
                new DateTimeGenerator(20*365, 40*365, true);
    }

    public void generate(CustProfileRepository repository){
        for(long i=0;i<count;i++) {
            CustProfile custProfile = new CustProfile();
            custProfile.setFirstName(stringGenerator.generate());
            custProfile.setLastName(stringGenerator.generate());
            custProfile.setPAN(panGenerator.generateNext());
            custProfile.setPassportNo(passportNoGenerator.generateNext());
            custProfile.setDOB(dateTimeGenerator.generateNextDate());
            repository.save(custProfile);
        }
    }
}
