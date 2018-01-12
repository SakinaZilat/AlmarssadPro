import axios from 'axios';

export const FETCH_LISTING = 'FETCH_LISTING';
export const FETCH_LISTING_COUNT = 'FETCH_LISTING_COUNT';

//Actionsare the only way to get data into the store.
export function fetchListing(url) {

  // console.log("MULE_ENDPOINT",url);
  const response = axios.get(url);
   console.log("fetchListing in Action",response);
  return {
    type: FETCH_LISTING,
    payload: response
  };
}

export function fetchListingCount(url) {

  // console.log("MULE_ENDPOINT",url);
  const response = axios.get(url);
  // console.log("fetchListing in Action",response);
  return {
    type: FETCH_LISTING_COUNT,
    payload: response
  };
}
