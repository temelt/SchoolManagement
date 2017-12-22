package com.temelt.schmgt.web.controller;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.temelt.schmgt.web.data.repository.GelirMuhasebeRepository;
import com.temelt.schmgt.web.data.repository.GiderMuhasebeRepository;
import com.temelt.schmgt.web.entity.muhasebe.Gelir;

@Controller("gelirTabloController")
@Scope("request")
public class GelirTabloController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private GelirMuhasebeRepository gelirRepository;
	@Autowired
	private GiderMuhasebeRepository giderRepository;

	private Date baslamaTarih;
	private Date bitisTarih;

	public Date getBaslamaTarih() {
		return baslamaTarih;
	}

	public Date getBitisTarih() {
		return bitisTarih;
	}

	private BarChartModel animatedModel2;
	private List<BigDecimal> liste = new ArrayList<>();

	public List<BigDecimal> getListe() {
		return liste;
	}

	public void setListe(List<BigDecimal> liste) {
		this.liste = liste;
	}

	@PostConstruct
	public void init() {
		createAnimatedModels();
	}

	public BarChartModel getAnimatedModel2() {
		return animatedModel2;
	}

	private void createAnimatedModels() {

		hesap();
		animatedModel2 = initBarModel();
		animatedModel2.setTitle("Bar Charts");
		animatedModel2.setAnimate(true);
		animatedModel2.setLegendPosition("ne");
		Axis yAxis = animatedModel2.getAxis(AxisType.Y);

		if (liste.get(0).intValue() > liste.get(1).intValue()) {

			int a = liste.get(0).intValue() + 100;
			yAxis.setMin(0);
			yAxis.setMax(a);
		} else {
			int b = liste.get(1).intValue() + 100;
			yAxis.setMin(0);
			yAxis.setMax(b);
		}
		liste.clear();

	}

	private BarChartModel initBarModel() {

		BarChartModel model = new BarChartModel();
		ChartSeries gelir = new ChartSeries();
		gelir.setLabel("Gelir");
		gelir.set("2017", liste.get(0));
		System.out.println("---------- liste 0 =" + liste.get(0));

		ChartSeries gider = new ChartSeries();
		gider.setLabel("Gider");
		gider.set("2017", liste.get(1));
		System.out.println("---------- liste 1 =" + liste.get(1));

		model.addSeries(gelir);
		model.addSeries(gider);

		return model;
	}

	public void hesap() {

		try {

			String string = "2000-20-01 00:00:00";
			DateFormat format = new SimpleDateFormat("yyyy-dd-MM HH:mm:ss");
			Date bas = format.parse(string);
			System.out.println(bas);

			String string1 = "2050-20-12 00:00:00";
			DateFormat format1 = new SimpleDateFormat("yyyy-dd-MM HH:mm:ss");
			Date son = format1.parse(string1);
			System.out.println(son);

			if (baslamaTarih == null || bitisTarih == null) {

				try {
					System.out.println("------------------------------------");
					BigDecimal gelirToplam = new BigDecimal(0);
					BigDecimal gelirToplamSonuc = gelirToplam.add(gelirRepository.getAllCountSumQuantity(bas, son));
					System.out.println(gelirToplamSonuc);
					liste.add(0, gelirToplamSonuc);
				} catch (NullPointerException e) {
					BigDecimal gelirToplamy = new BigDecimal(1);
					liste.add(0, gelirToplamy);
				}
				try {
					System.out.println("------------------------------------");
					BigDecimal giderToplam = new BigDecimal(0);
					BigDecimal giderToplamSonuc = giderToplam.add(giderRepository.getAllCountSumQuantity(bas, son));
					System.out.println(giderToplamSonuc);
					liste.add(1, giderToplamSonuc);
				} catch (NullPointerException e) {
					// TODO: handle exception
					BigDecimal giderToplamy = new BigDecimal(1);
					liste.add(1, giderToplamy);

				}

			} else {
				try {
					System.out.println("------------------------------------");
					BigDecimal gelirToplam = new BigDecimal(0);
					BigDecimal gelirToplamSonuc = gelirToplam
							.add(gelirRepository.getAllCountSumQuantity(baslamaTarih, bitisTarih));
					System.out.println(gelirToplamSonuc);
					liste.add(0, gelirToplamSonuc);
				} catch (NullPointerException e) {
					BigDecimal gelirToplamy = new BigDecimal(1);
					liste.add(0, gelirToplamy);
				}
				try {
					System.out.println("------------------------------------");
					BigDecimal giderToplam = new BigDecimal(0);
					BigDecimal giderToplamSonuc = giderToplam
							.add(giderRepository.getAllCountSumQuantity(baslamaTarih, bitisTarih));
					System.out.println(giderToplamSonuc);
					liste.add(1, giderToplamSonuc);
				} catch (NullPointerException e) {
					// TODO: handle exception
					BigDecimal giderToplamy = new BigDecimal(1);
					liste.add(1, giderToplamy);

				}
			}

		} catch (ParseException e) {
			// TODO: handle exception
		}

	}

}
