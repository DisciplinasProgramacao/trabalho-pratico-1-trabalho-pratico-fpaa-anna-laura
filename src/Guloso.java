public class Guloso {
        public Integer buscaMelhorCaso(Lamina lamina) {
        while (lamina.getEspessura() > 4) {
            int melhorCusto = Integer.MAX_VALUE;
            int caso = 1;
            Lamina clone = lamina.clone();
            clone.reduzirLamina(1);
            clone.reduzirLamina(1);
            clone.reduzirLamina(1);
            if (clone.getCusto() <= melhorCusto) {
                melhorCusto = clone.getCusto();
            }
            clone = lamina.clone();
            clone.reduzirLamina(1);
            clone.reduzirLamina(2);
            if (clone.getCusto() <= melhorCusto) {
                melhorCusto = clone.getCusto();
                caso = 2;
            }
            clone = lamina.clone();
            clone.reduzirLamina(2);
            clone.reduzirLamina(1);
            if (clone.getCusto() <= melhorCusto) {
                melhorCusto = clone.getCusto();
                caso = 3;
            }
            clone = lamina.clone();
            clone.reduzirLamina(3);
            if (clone.getCusto() <= melhorCusto) {
                melhorCusto = clone.getCusto();
                caso = 4;
            }
            fazGuloso(caso, lamina);
        }
        return lamina.getCusto();
    }
    public void fazGuloso(int caso, Lamina lamina){
        switch (caso) {
            case 1:
                lamina.reduzirLamina(1);
                lamina.reduzirLamina(1);
                lamina.reduzirLamina(1);
                break;
            case 2:
                lamina.reduzirLamina(1);
                lamina.reduzirLamina(2);
                break;
            case 3:
                lamina.reduzirLamina(2);
                lamina.reduzirLamina(1);
                break;
            case 4:
                lamina.reduzirLamina(3);
                break;
        }
    }
}
