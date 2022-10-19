package primitiveObsessionFix;

import java.util.regex.Pattern;

public class Name {
    private String value;
    
    public Name(String value){
        if(!isValidName(value)){
            throw new IllegalArgumentException("name is not valid");
        }
        
        this.value = value;
    }
    
    private boolean isValidName(String name){
        String regex = "^\\p{L}+[\\p{L}\\p{Z}\\p{P}]{0,}";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(name).matches();
    }
    
    public String getValue(){
        return this.value;
    }
}
