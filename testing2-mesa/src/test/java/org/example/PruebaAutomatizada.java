package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PruebaAutomatizada {

    public static void main(String[] args) {
        // Configurar la ubicación del ChromeDriver (asegúrate de tener el ChromeDriver adecuado para tu versión de Chrome)
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver");

        // Crear una instancia de WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Maximizar la ventana del navegador
            driver.manage().window().maximize();

            // Abrir la página de inicio de Mercado Libre
            driver.get("https://www.mercadolibre.com.ar/");

            // Verificar que la página de inicio de Mercado Libre esté visible
            String pageTitle = driver.getTitle();
            if (pageTitle.contains("Mercado Libre")) {
                System.out.println("Página de inicio de Mercado Libre está visible.");
            } else {
                System.out.println("La página de inicio de Mercado Libre no se pudo cargar correctamente.");
            }

            // Buscar 'iPhone 13' en el buscador
            WebElement searchBox = driver.findElement(By.name("as_word"));
            searchBox.sendKeys("iPhone 13");
            searchBox.submit();

            // Verificar que los resultados sean acordes a la búsqueda realizada
            if (driver.getTitle().contains("Resultados de búsqueda para 'iPhone 13'")) {
                System.out.println("Los resultados son acordes a la búsqueda realizada.");
            } else {
                System.out.println("Los resultados no son acordes a la búsqueda realizada.");
            }

            // Filtrar por almacenamiento: 256 GB
            WebElement filterButton = driver.findElement(By.linkText("256 GB"));
            filterButton.click();

            // Verificar que el filtro se aplique correctamente
            if (driver.getCurrentUrl().contains("&storage=256GB")) {
                System.out.println("El filtro se aplicó correctamente.");
            } else {
                System.out.println("El filtro no se aplicó correctamente.");
            }

            // Hacer clic en 'Comprar ahora'
            WebElement buyNowButton = driver.findElement(By.linkText("Comprar ahora"));
            buyNowButton.click();

            // Verificar que se redirija a la página de inicio de sesión
            if (driver.getTitle().contains("Inicia sesión")) {
                System.out.println("El usuario fue redirigido a la página de inicio de sesión.");
            } else {
                System.out.println("La redirección a la página de inicio de sesión no ocurrió correctamente.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cerrar el navegador al finalizar
            driver.quit();
        }
    }
}