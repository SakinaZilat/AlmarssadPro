import React from 'react';
// import {Table, Column, Cell} from 'fixed-data-table';

import { BootstrapTable, TableHeaderColumn } from 'react-bootstrap-table';

class PlayersList extends React.Component {
    constructor(props) {
        super(props);
       
    }

    render() {
        return <div className="panel panel-default">
            <div className="panel-heading">
                <span className="lead">List of Players </span>
            </div>

            <div className="tablecontainer">
                <BootstrapTable data={this.props.players} striped={true} hover={true}  striped hover condensed>
                <TableHeaderColumn dataField='id' isKey hidden>ID</TableHeaderColumn>
                    <TableHeaderColumn dataField="firstName" dataSort={true}>Name</TableHeaderColumn>
                    <TableHeaderColumn dataField="lastName" dataSort={true}>LastName</TableHeaderColumn>
                    <TableHeaderColumn dataField="age" dataSort={true}>Age</TableHeaderColumn>
                    <TableHeaderColumn dataField="birthDate" dataSort={true}>Birthdate</TableHeaderColumn>
                    <TableHeaderColumn dataField="birthCountry" dataSort={true}>Country of birth</TableHeaderColumn>
                    <TableHeaderColumn dataField="nationality" dataSort={true}>Nationality</TableHeaderColumn>
                    <TableHeaderColumn dataField="position" dataSort={true}>position</TableHeaderColumn>
                    <TableHeaderColumn dataField="nowClub" dataSort={true}>Actuel Club</TableHeaderColumn>

                </BootstrapTable>;
            </div>
        </div>
    }

}


export default PlayersList;