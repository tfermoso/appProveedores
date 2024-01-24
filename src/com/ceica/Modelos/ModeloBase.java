import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public abstract class ModeloBase {
    private static final String CONFIG_FILE = "config.properties";
    protected static String URL;
    protected static String USUARIO;
    protected static String PASSWORD;

    static {
        cargarConfiguracion();
    }

    private static void cargarConfiguracion() {
        Properties propiedades = new Properties();
        try (FileInputStream entrada = new FileInputStream(CONFIG_FILE)) {
            propiedades.load(entrada);
            URL = propiedades.getProperty("db.url");
            USUARIO = propiedades.getProperty("db.usuario");
            PASSWORD = propiedades.getProperty("db.contraseña");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método abstracto para obtener el nombre de la tabla
    protected abstract String getNombreTabla();

    // Métodos para CRUD

    protected void insertar(String sql, Object... parametros) {
        ejecutarQuery(sql, parametros);
    }

    protected void actualizar(String sql, Object... parametros) {
        ejecutarQuery(sql, parametros);
    }

    protected void borrar(String sql, Object... parametros) {
        ejecutarQuery(sql, parametros);
    }

    // Método para leer datos de la base de datos
    protected void leer(String sql, Object... parametros) {
        // Implementa la lógica para leer datos
    }

    // Método genérico para ejecutar consultas SQL
    private void ejecutarQuery(String sql, Object... parametros) {
        try (Connection conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
             PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {

            // Establecer los valores de los parámetros
            for (int i = 0; i < parametros.length; i++) {
                preparedStatement.setObject(i + 1, parametros[i]);
            }

            // Ejecutar la consulta
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

