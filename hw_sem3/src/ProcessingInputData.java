import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProcessingInputData {

    public void ProcessingData() throws Exception{

        InputData inputData = new InputData();
        String[] ChekedArrayData = inputData.checkInputData();

        String lastName = ChekedArrayData[0];
        String name = ChekedArrayData[1];
        String midleName = ChekedArrayData[2];

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Date birthDate;
        try {
            birthDate = sdf.parse(ChekedArrayData[3]);
        } 
        catch (ParseException e) {
            throw new ParseException("Вы ввели некорректную дату: " + ChekedArrayData[3] + ", требуемый формат: dd.mm.yyyy", 0);
        }

        long phoneNum;
        try {
            phoneNum = Long.parseLong(ChekedArrayData[4]);
        } 
        catch (NumberFormatException e) {
            throw new NumberFormatException(
                    "Вы ввели некорректный номер телефона: " + ChekedArrayData[4] + ", требуемый формат: 89991234567");
        }

        String sex = ChekedArrayData[5];
        try {
            if (!sex.toLowerCase().equals("m") && !sex.toLowerCase().equals("f")){
                throw new SexException("Неверно введен пол, вы указали "+ ChekedArrayData[5].toLowerCase());
            }    
        } 
        catch (SexException e) {
            e.printStackTrace();
        }

        try (PrintWriter out = new PrintWriter(new FileWriter(lastName.toLowerCase() + ".txt", true))){
            out.write(String.format("%s %s %s %s %s %s", lastName, name, midleName, sdf.format(birthDate), phoneNum, sex + "\n"));
        }
        catch(IOException e){
            throw new IOException("Произошла ошибка записи");
        }
    }
}
