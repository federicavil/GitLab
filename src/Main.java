import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args){
        System.out.println("Hello world");
        try {
            retrieveCommit("C:/Users/Federica/git/GitLab","added");
        }catch(Exception e) {
            System.out.println("Exception");
        }
    }

    public static void retrieveCommit(String path, String toSearch) throws Exception {
                ProcessBuilder builder = new ProcessBuilder(
                        "cmd.exe", "/c", "cd " + path+ " && git log --grep="+toSearch+" --date=iso-strict" );
                builder.redirectErrorStream(true);
                Process p = builder.start();
                BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
                String line;
                while (true) {
                    line = r.readLine();
                    if (line == null) { break; }
                    System.out.println(line);
                }


    }
}
