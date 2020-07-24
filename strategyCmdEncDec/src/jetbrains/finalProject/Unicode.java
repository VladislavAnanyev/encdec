package jetbrains.finalProject;

public class Unicode implements RunAlgorithm {

    @Override
    public void run(String mode, char[] chars, int key) {
        if (mode.equals("enc"))
        {
            for (int i = 0; i < chars.length ; i++) {
                chars[i] = (char) ((int) chars[i] + key);
            }
        }
        if (mode.equals("dec"))
        {
            for (int i = 0; i < chars.length ; i++) {
                chars[i] = (char) ((int) chars[i] - key);
            }
        }
    }
}
