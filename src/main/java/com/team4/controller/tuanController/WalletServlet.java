package com.team4.controller.tuanController;

import com.team4.model.tuanModel.CurrencyWallet;
import com.team4.model.tuanModel.UserWallet;
import com.team4.model.tuanModel.Wallet;
import com.team4.service.tuanService.wallet.currency.CurrencyService;
import com.team4.service.tuanService.wallet.currency.ICurrencyService;
import com.team4.service.tuanService.wallet.IWalletService;
import com.team4.service.tuanService.wallet.WalletService;
import com.team4.service.tuanService.wallet.users.IUserWalletService;
import com.team4.service.tuanService.wallet.users.UserWalletService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "WalletServlet", value = "/wallets")
public class WalletServlet extends HttpServlet {
    IWalletService walletService = new WalletService();
    ICurrencyService currencyService = new CurrencyService();
    IUserWalletService userWalletService = new UserWalletService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                default:
                    listWallet(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertWallet(request, response);
                    break;
                case "edit":
                    updateWallet(request, response);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void listWallet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Wallet> wallets = walletService.selectAll();
        request.setAttribute("wallets", wallets);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("wallet/list.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("currencies", currencyService.selectAll());
        request.setAttribute("userWallet", userWalletService.selectAll());
        RequestDispatcher dispatcher = request.getRequestDispatcher("wallet/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Wallet wallet = walletService.getById(id);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("wallet/edit.jsp");
        request.setAttribute("editingWallet", wallet);
        requestDispatcher.forward(request, response);
    }


    private void insertWallet(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String name = request.getParameter("name");
        int a = Integer.parseInt(request.getParameter("currencies"));
        CurrencyWallet currencyWallet = currencyService.getById(a);
        int b = Integer.parseInt(request.getParameter("user"));
        UserWallet userWallet = userWalletService.getById(b);
        double balance = Double.parseDouble(request.getParameter("balance"));
        String description = request.getParameter("description");
        Wallet wallet = new Wallet(name, currencyWallet, userWallet, balance, description);
        walletService.insert(wallet);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("wallet/create.jsp");
        requestDispatcher.forward(request, response);
    }

    private void updateWallet(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double balance = Double.parseDouble(request.getParameter("balance"));
        String description = request.getParameter("description");

        Wallet editingWallet = new Wallet(id, name, balance, description);
        walletService.update(editingWallet);
        RequestDispatcher dispatcher = request.getRequestDispatcher("wallet/edit.jsp");
        dispatcher.forward(request, response);
    }
}
