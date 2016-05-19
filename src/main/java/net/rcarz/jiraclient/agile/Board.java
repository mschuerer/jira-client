/**
 * jira-client - a simple JIRA REST client
 * Copyright (c) 2013 Bob Carroll (bob.carroll@alum.rit.edu)
 * <p>
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * <p>
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * <p>
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */

package net.rcarz.jiraclient.agile;

import net.rcarz.jiraclient.JiraException;
import net.rcarz.jiraclient.RestClient;
import net.sf.json.JSONObject;

import java.util.List;

/**
 * Represents an Agile Board.
 *
 * @author pldupont
 */
public class Board extends AgileResource {

    public static final String ATTR_TYPE = "type";

    /**
     * Creates a rapid view from a JSON payload.
     *
     * @param restclient REST client instance
     * @param json       JSON payload
     */
    protected Board(RestClient restclient, JSONObject json) {
        super(restclient, json);
    }

    /**
     * Retrieves the given rapid view.
     *
     * @param restclient REST client instance
     * @param id         Internal JIRA ID of the rapid view
     * @return a rapid view instance
     * @throws JiraException when the retrieval fails
     */
    public static Board get(RestClient restclient, int id) throws JiraException {
        return AgileResource.get(restclient, Board.class, RESOURCE_URI + "board/" + id);
    }

    /**
     * Retrieves all boards visible to the session user.
     *
     * @param restclient REST client instance
     * @return a list of boards
     * @throws JiraException when the retrieval fails
     */
    public static List<Board> getAll(RestClient restclient) throws JiraException {
        return AgileResource.list(restclient, Board.class, RESOURCE_URI + "board");
    }

    /**
     * @return The board type.
     */
    public String getType() {
        return getAttribute(ATTR_TYPE);
    }

    public List<Sprint> getSprints() throws JiraException {
        return AgileResource.list(getRestclient(), Sprint.class, RESOURCE_URI + "board/" + getId() + "/sprint");
    }

//    /**
//     * Retrieves the sprint report for the given sprint.
//     *
//     * @param sprint Sprint to lookup
//     *
//     * @return the sprint report
//     *
//     * @throws JiraException when the retrieval fails
//     */
//    public SprintReport getSprintReport(Sprint sprint) throws JiraException {
//        return SprintReport.get(restclient, this, sprint);
//    }
//
//    /**
//     * Retrieves the backlog data for this rapid view.
//     *
//     * @return the backlog
//     *
//     * @throws JiraException when the retrieval fails
//     */
//    public Backlog getBacklogData() throws JiraException {
//        return Backlog.get(restclient, this);
//    }
}

