/*
 * Copyright 2020-2030 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.group.foctg.holidayMaker.model;

import java.util.Date;
import java.util.List;

/**
 * This class holds a static method that will check if two ranges of Dates
 * overlap or not.
 *
 * @author Christoffer Hansen &lt;chris.hansen.ch@outlook.com&gt;
 */
public class DateChecker {

    /**
     * Method that makes a check if the two ranges overlap or not
     * 
     * @param dateRangeFrom1 
     * @param dateRangeTo1
     * @param dateRangeFrom2
     * @param dateRangeTo2
     * @return a boolean value on whether ranges overlap
     */
    public static boolean isOverlapping(Date dateRangeFrom1, Date dateRangeTo1,
            Date dateRangeFrom2, Date dateRangeTo2) {
        return (dateRangeFrom1.getTime() <= dateRangeTo2.getTime()
                && dateRangeFrom2.getTime() <= dateRangeTo1.getTime());
    }
}
