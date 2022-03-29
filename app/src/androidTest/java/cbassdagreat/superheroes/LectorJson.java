package cbassdagreat.superheroes;

import androidx.test.platform.app.InstrumentationRegistry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LectorJson {
    public  static String lector(String archivo)
    {
        try {
            InputStream input = InstrumentationRegistry.getInstrumentation().getTargetContext().getAssets().open(archivo);
            StringBuilder sb = new StringBuilder();
            InputStreamReader sr = new InputStreamReader(input);
            BufferedReader br = new BufferedReader(sr);
            String data = br.readLine();
            while (data != null)
            {
                sb.append(data);
                data = br.readLine();
            }

            return sb.toString();


        }
        catch (IOException ex)
        {
            return null;
        }
    }
}
