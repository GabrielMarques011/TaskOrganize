package util;

import android.app.Activity;
import android.content.pm.PackageManager;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class PermissionUtil {

    //ELE ESTÁ RECEBENDO A STRING ASSIM, POIS PODEM SER DIVERSAS STRINGS
    public static boolean checarPermissao(Activity activity, int requestCod, String... permissoes){

        List<String> negadas = new ArrayList<>();

        //PERCORRER AS PERMISÕES PROCURANDO AS NEGADAS
        for (String permissao : permissoes){
            //DIFERENTE DE PERMITIDO
            if (ContextCompat.checkSelfPermission(activity, permissao) != PackageManager.PERMISSION_GRANTED){
                    negadas.add(permissao);
            }
        }

        //SE A LISTA DE NEGADAS ESTÁ VAZIA, RETORNA TRUE E SEGUE
        if (negadas.isEmpty()){
            return true;
        }

        //CHECANDO AS PERMISSÕES
        //CONVERTE A LISTA EM VETOR
        String[] permissoesNegadas = new String[negadas.size()];
        negadas.toArray(permissoesNegadas);
        //METODO QUE APARECE A CAIXINHA QUE PEDE PARA 'PERMITIR' TAL COISA
        ActivityCompat.requestPermissions(activity, permissoesNegadas, requestCod);

        return false;

    }

}
