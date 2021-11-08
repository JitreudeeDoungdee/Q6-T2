import java.io.File;
import java.io.IOException;

public class Search {
    private static String LDirec;
    private static boolean notFounded = true;
    public static void main(String[] args) throws IOException {
        Search s = new Search();
        String path = "/home";
        String SearchWord = "setup-Files";
        s.showDirectory(path,SearchWord);
    }
    void showDirectory(String Path, String SearchWord) throws IOException {
        File file = new File(Path);
        if(file.isDirectory()){
            String[] names = file.list();
            assert names != null;
            for (String name : names) {
                LDirec = Path + "/" + name;
                if (IsMatch(name, SearchWord)) {
                    OP();
                    File fileFN = new File(LDirec);
                    String[] namesFN = fileFN.list();
                    for (String name2 : namesFN) {
                        File fileBuf = new File(Path+ "/" + name2);
                        //System.out.println("\tFolder : " + Path+ "/" + name2 + fileBuf.isDirectory());
                        if(fileBuf.isDirectory()){
                            System.out.println("\tFolder : " + name2);
                        }
                        else {
                            System.out.println("\tFile : " + name2);
                        }
                    }
                }
                showDirectory(Path + "/" + name, SearchWord);
            }
        }
    }
    boolean IsMatch(String word, String pattern){
        return word.equals(pattern);
    }
    void OP(){
        System.out.println("Directory : " + LDirec);
        notFounded = false;
    }
}
