package ExerciciosEbac;

import java.lang.reflect.Method;
import java.util.List;

public class Reflexao {

    static class MinhaClasse {
        private List<String> lista;

        public List<String> getLista() {
            return lista;
        }

        public void setLista(List<String> lista) {
            this.lista = lista;
        }
    }

    public static void main(String[] args) throws Exception {

        MinhaClasse obj = new MinhaClasse();

        Class<?> arrayListClass = Class.forName("java.util.ArrayList");
        Object listaInstance = arrayListClass.getDeclaredConstructor().newInstance();

        Method setLista = MinhaClasse.class.getMethod("setLista", List.class);
        setLista.invoke(obj, listaInstance);

        Method addMethod = arrayListClass.getMethod("add", Object.class);
        addMethod.invoke(listaInstance, "Java");
        addMethod.invoke(listaInstance, "Reflection");
        addMethod.invoke(listaInstance, "EBAC");

        Method getLista = MinhaClasse.class.getMethod("getLista");
        Object listaObtida = getLista.invoke(obj);

        Method iteratorMethod = listaObtida.getClass().getMethod("iterator");
        var iterator = (java.util.Iterator<?>) iteratorMethod.invoke(listaObtida);

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
