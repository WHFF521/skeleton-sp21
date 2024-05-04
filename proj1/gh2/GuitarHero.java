package gh2;
import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;

public class GuitarHero {
    private String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
    private GuitarString[] strings = new GuitarString[37];

    public GuitarHero() {
        for (int i = 0; i < 37; i++) {
            strings[i] = new GuitarString(440.0 * Math.pow(2, (i - 24) / 12.0));
        }
    }

    public static void main(String[] args) {
        GuitarHero gh = new GuitarHero();
        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int index = gh.keyboard.indexOf(key);
                if (index != -1) {
                    gh.strings[index].pluck();
                }
            }
            double sample = 0.0;
            for (int i = 0; i < 37; i++) {
                sample += gh.strings[i].sample();
            }
            StdAudio.play(sample);
            for (int i = 0; i < 37; i++) {
                gh.strings[i].tic();
            }
        }
    }

}
