package org.victoria2.tools.vic2sgea.gui;

import javafx.scene.chart.PieChart;
import org.victoria2.tools.vic2sgea.entities.Country;
import org.victoria2.tools.vic2sgea.entities.Product;
import org.victoria2.tools.vic2sgea.entities.ProductStorage;
import org.victoria2.tools.vic2sgea.main.Report;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class ProductController extends ChartsController {
    private final Product product;

    private void addUniChart(Function<ProductStorage, Float> getter, String name) {
        List<ChartSlice> slices = new ArrayList<>();

        float total = 0;
        float totalSum;

        for (Country country : report.getCountryList()) {
            if (country.getTag().equals(Report.TOTAL_TAG))
                continue;
            ProductStorage productStorage = country.findStorage(product);
            if (productStorage == null)
                continue;

            float value = getter.apply(productStorage);

            slices.add(new ChartSlice(country.getTag(), value));
            total += value;
        }

        totalSum = total * product.price;
        String title = String.format("%s %s (%.1f 单位, %.1f£)", name, product.getName(), total, totalSum);

        Function<PieChart.Data, String> onEnter = data -> {
            Country country = report.getCountry(data.getName());
            String countryName = (country == null) ? data.getName() : country.getOfficialName();
            return String.format("%s: %.2f 单位, %.2f£",
                    countryName, data.getPieValue(), data.getPieValue() * product.price);
        };

        Consumer<PieChart.Data> onClick = data -> Main.showCountry(report, report.getCountry(data.getName()));

        addChart(slices, title, onEnter, onClick);
    }

    ProductController(final Report report, Product product) {
        super(report);
        this.product = product;
        addUniChart(ProductStorage::getGdp, "国别产量 - ");
        addUniChart(ProductStorage::getBought, "国别消费量 - ");
        addUniChart(ProductStorage::getExported, "国别出口量 - ");
        addUniChart(ProductStorage::getImported, "国别进口量 - ");
        //addUniChart("maxDemand",2,0, "maxDemand ");
/*
        addUniChart("worldmarketPool", 0, 4, "worldmarketPool ");
        addUniChart("actualSoldWorld", 1, 4, "actualSoldWorld ");
*/
        addUniChart(ProductStorage::getTotalSupply, "国别供应量 - ");
        addUniChart(ProductStorage::getSold, "实际国别供应量 - ");

    }
}
