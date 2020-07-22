package donut;

import java.util.Arrays;

public class Donut {
    /*algumas constantes*/
    static final char[] tabelaLuminosidade = {'.', ',', '-', '~', ':', ';', '=', '!', '*', '#', '$', '@'};
    static final float R1 = 1; //raio donut
    static final float R2 = 2; //espessura do donut
    static final float K2 = 5;
    //no codigo original ele calcula K1 com base no tamaho da tela
    static final float K1 = 5;
 
    //para os angulos
    static final float passoFi = 0.02f;
    static final float passoTeta = 0.07f;

    //pontos sobre o qual o donut ira rodar
    //o eixo x é sobre o ponto A
    //o eixo z é sobre o ponto B
    static final double A = 0;
    static final double B = 0;
    public static void main(String args[]) {
        int screenWidth = 256;
        int screenHeight = 256;

        double sinA = Math.sin(A), cosA = Math.cos(A),
            sinB = Math.sin(B), cosB = Math.cos(B);
        
        char[][] donut = new char[256][256];
        double[][] zBuffer = new double[256][256];

        //preenche com 0 e ' '
        for (int i = 0; i < 256; i++) Arrays.fill(donut[i], ' ');
        for (double[] row: zBuffer) Arrays.fill(row, 0.0);

        //inicia calculos
        for(double teta = 0.0d; teta < 2*Math.PI; teta+=passoTeta){
            double cosTeta = Math.cos(teta), sinTeta = Math.sin(teta);
            for(double fi = 0.0d; fi < 2*Math.PI; fi+=passoFi){
                double sinFi = Math.sin(fi), cosFi = Math.cos(fi);
                
                //coordenadas do circulo
                double circleX = R2 + R1 * cosTeta;
                double circleY = R1 * sinTeta;
                //coordenadas x, y, z, depois da rotacao
                double x = circleX*(cosB*cosFi + sinA*sinB*sinFi)- circleY*cosA*sinB; 
                double y = circleX*(sinB*cosFi - sinA*cosB*sinFi) + circleY*cosA*cosB;
                double z = K2 + cosA*circleX*sinFi + circleY*sinA;
                double ooz = 1/z;  // "one over z"
                //pojecao de x e y
                int projX = (int)(screenWidth/2 + K1*ooz*x);
                int projY = (int)(screenWidth/2 - K1*ooz*y);

                //calcula a luminosidade
                double L = cosFi*cosTeta*sinB - cosA*cosTeta*sinFi -
                            sinA*sinTeta + cosB*(cosA*sinTeta - cosTeta*sinA*sinFi);
                if(L > 0){
                    if(ooz > zBuffer[projX][projY])
                    {
                        int index_luminosidade =(int) L*8;
                        donut[projX][projY] = tabelaLuminosidade[index_luminosidade];
                    }
                }
            }
        }
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
        
        for (int j = 0; j < screenHeight; j++) {
            for (int i = 0; i < screenWidth; i++) {
                System.out.print(donut[i][j]);
            }
            System.out.println();
        }

    }
}