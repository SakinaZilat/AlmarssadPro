import React, {Component} from 'react';
import {connect} from 'react-redux';
import PlayersList from "../components/PlayersList";
import {fetchListing} from '../actions/index';
import {bindActionCreators} from 'redux';
import axios from 'axios';
import {LISTING_ENDPOINT} from '../components/config';

class Players extends Component {
  componentDidMount() {
    console.log("LISTING_ENDPOINT", LISTING_ENDPOINT);
    this.props.fetchListing(LISTING_ENDPOINT);
  }

  render() {
    return (
      <div>
        <PlayersList players={this.props.players}/>
  

       </div>
    )
  }
}

function mapStateToProps(state) {
  // Whatever is returnend will show up as props inside of expertList
   console.log('Inside mapStateToProps ', state);
  return {players: state.players};
}

function mapDispatchToProps(dispatch) {
  return bindActionCreators({
    fetchListing
  }, dispatch);
}

export default connect(mapStateToProps, mapDispatchToProps)(Players);
