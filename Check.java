public class Check {
    public void isCode(String code) throws ValidateException{
        if(!code.matches("^[Bb]{1}\\d{2}[A-Za-z]{4}\\d{3}$"))
            throw new ValidateException("error code");
    }

    public void isFullname(String name){
        
    }

    public void isPhone(String phone) throws ValidateException{
        if(!phone.matches("\\d{10}$"))
            throw new ValidateException("error phone");
    }

    public void isDate(String dob) throws ValidateException{
        if(!dob.matches("\\d{1,2}\\/\\d{1,2}\\/\\d{4}"))
            throw new ValidateException("error date");
    }

    
}
