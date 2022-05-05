package com.example.Transportetotal.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "expenses_by_vehicle")
public class ExpensesByVehicle {

    @EmbeddedId
    private ExpensesByVehicleId id = new ExpensesByVehicleId();

    @ManyToOne
    @MapsId("expenseId")
    private Expense expense;

    @ManyToOne
    @MapsId("vehicleId")
    private Vehicle vehicle;

    private Double cost;

    public ExpensesByVehicle(ExpensesByVehicleId id, Expense expense, Vehicle vehicle, Double cost) {
        this.id = id;
        this.expense = expense;
        this.vehicle = vehicle;
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ExpensesByVehicle that = (ExpensesByVehicle) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
