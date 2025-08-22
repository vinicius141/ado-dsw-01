package br.com.carstore.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/create-car")
public class CreateCarServlet extends HttpServlet {

    private static final List<String> carros = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Pegando os dados do formulário
        String carName = request.getParameter("car-name");
        String cor = request.getParameter("cor");
        String tipo = request.getParameter("tipo");

        // Criando JSON do carro
        String carroJson = String.format(
                "{ \"carName\": \"%s\", \"cor\": \"%s\", \"tipo\": \"%s\" }",
                carName, cor, tipo
        );

        // Salvando em memória
        carros.add(carroJson);

        // Resposta JSON completa
        response.setContentType("application/json;charset=UTF-8");
        String resposta = String.format(
                "{ \"carName\": \"%s\", \"cor\": \"%s\", \"tipo\": \"%s\", \"status\": \"registrado com sucesso\" }",
                carName, cor, tipo
        );

        response.getWriter().write(resposta);
    }
}
