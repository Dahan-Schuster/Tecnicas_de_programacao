import java.awt.Color;

public class GrayScaleFilter extends Filter {

    private static final double RED_CONTRIBUTION = 0.30,
                                GREEN_CONTRIBUTION = 0.59,
                                BLUE_CONTRIBUTION = 0.11;

    public GrayScaleFilter(String name) {
        super(name);
    }

    /**
     * Retorna o valor formatado para escala de cinza baseado nos values
     * de vermelho, verde e azul
     * Uma simples média dos três valores funciona, porém resulta em uma
     * imagem muito escura devido ao formato de onda de cada cor
     * Fazendo a média, cada cor contribui com 33%
     * 
     * Para um efeito mais bonito aos olhos deve-se considerar que:
     * Vermelho, por ter uma onda mais longa, deve contribuir menos para o cinza
     * Verde deve contribuir mais, pois tem uma onda mais curta e também dá um
     * efeito mais suavizante à imagem
     * Azul deve contribuir com o restante para completar 100% do valor 
     * 
     * @param r vermelho
     * @param g verde
     * @param b azul
     * @return o valor de cinza referente à cor RGB recebida
     */
    private int applyGrayscaleFormula(int r, int g, int b) {
        return (int) (r * RED_CONTRIBUTION + g * GREEN_CONTRIBUTION + b * BLUE_CONTRIBUTION);
    }

    @Override
    public void apply(OFImage image) {
        int height = image.getHeight();
        int width = image.getWidth();
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                Color pixel = image.getPixel(x, y);

                int red = pixel.getRed();
                int green = pixel.getGreen();
                int blue = pixel.getBlue();

                red = green = blue = applyGrayscaleFormula(red, green, blue);

                Color grayColor = new Color(red, green, blue);
                image.setRGB(x, y, grayColor.getRGB());
            }
        }
    }

}
