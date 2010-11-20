/*
 * Created on 17/apr/2010
 * Copyright (C) 2010 by Andrea Vacondio (andrea.vacondio@gmail.com).
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 * 
 */
package org.sejda.core.notification.event;

import java.math.BigDecimal;

/**
 * Event used to notify about the increasing percentage of work executed by the task.
 * 
 * @author Andrea Vacondio
 * 
 */
public class PercentageOfWorkDoneChangedEvent extends AbstractNotificationEvent {

    private static final long serialVersionUID = -9123790950056705713L;

    public static final BigDecimal UNDETERMINATE = new BigDecimal("-1");
    public static final BigDecimal MAX_PERGENTAGE = new BigDecimal("100");

    private BigDecimal percentage = BigDecimal.ZERO;

    /**
     * Default constructor with percentage zero.
     */
    public PercentageOfWorkDoneChangedEvent() {
        super();
    }

    /**
     * creates and event with the given percentage
     * 
     * @param percentage
     */
    public PercentageOfWorkDoneChangedEvent(BigDecimal percentage) {
        setPercentage(percentage);
    }

    public BigDecimal getPercentage() {
        return percentage;
    }

    /**
     * Sets the percentage for this event
     * 
     * @param percentage
     */
    public final void setPercentage(BigDecimal percentage) {
        if (BigDecimal.ZERO.compareTo(percentage) > 0) {
            this.percentage = UNDETERMINATE;
        } else {
            this.percentage = MAX_PERGENTAGE.min(percentage);
        }
    }

    /**
     * @return true if the percentage is undetermined for this event
     */
    public boolean isUndetermined() {
        return BigDecimal.ZERO.compareTo(percentage) > 0;
    }

    @Override
    public String toString() {
        return "PercentageOfWorkDoneChangedEvent [percentage=" + percentage + "]";
    }

}
