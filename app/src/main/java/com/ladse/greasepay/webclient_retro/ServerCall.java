package com.ladse.greasepay.webclient_retro;

import com.ladse.greasepay.booking.AddRemoveFavoriteRequest;
import com.ladse.greasepay.booking.BookingListResponse;
import com.ladse.greasepay.booking.BookingRedemptionRequest;
import com.ladse.greasepay.booking.card_booking.BarBookingRequest;
import com.ladse.greasepay.common.Model;
import com.ladse.greasepay.constants.AppConstatnts;
import com.ladse.greasepay.constants.UrlConstants;
import com.ladse.greasepay.debitcard.model.CardRequest;
import com.ladse.greasepay.debitcard.model.CardResponse;
import com.ladse.greasepay.debitcard.model.DeleteCardRequest;
import com.ladse.greasepay.debitcard.model.DeleteCardResponse;
import com.ladse.greasepay.faq.FAQResponse;
import com.ladse.greasepay.home.model.RestaurantRequest;
import com.ladse.greasepay.home.model.RestaurantResponse;
import com.ladse.greasepay.login.ForgotPasswordRequest;
import com.ladse.greasepay.login.LoginRequest;
import com.ladse.greasepay.login.SocialLoginResponse;
import com.ladse.greasepay.profile.ProfileRequest;
import com.ladse.greasepay.promocode.checkpromocode.model.CheckPromoCodeRequest;
import com.ladse.greasepay.promocode.checkpromocode.model.CheckPromoCodeResponse;
import com.ladse.greasepay.sinup.SignUpRequest;
import com.ladse.greasepay.sinup.model.LoginSinUpResponse;
import com.ladse.greasepay.sinup.model.SocialSinupRequest;
import com.ladse.greasepay.stripe.StripeRequest;
import com.ladse.greasepay.stripe.StripeResponse;
import com.ladse.greasepay.stripe.StripeTokenResponse;
import com.ladse.greasepay.upcomingevents.EventRequest;
import com.ladse.greasepay.upcomingevents.EventResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;


public interface ServerCall {

    @Headers( "Content-Type: application/json" )
    @POST (UrlConstants.SIGN_UP_API)
    Call<LoginSinUpResponse>  sinUp(@Body SignUpRequest jsonBody );

    @Headers({AppConstatnts.ApiHeader.CONTENT_TYPE_JSON})
    @POST(UrlConstants.LOGIN_API)
    Call<LoginSinUpResponse> login(@Body LoginRequest jsonBody);

    @Headers({AppConstatnts.ApiHeader.CONTENT_TYPE_JSON})
    @POST(UrlConstants.RESTAURANT_SEARCH)
    Call<RestaurantResponse> getRestaurantData(@Header(AppConstatnts.ApiHeader.AUTHORIZATION_HEADER) String authToken, @Body RestaurantRequest jsonBody);

    @Headers({AppConstatnts.ApiHeader.CONTENT_TYPE_JSON})
    @POST(UrlConstants.UPCOMING_EVENTS)
    Call<EventResponse> getUpComingEventsData(@Header(AppConstatnts.ApiHeader.AUTHORIZATION_HEADER) String authToken, @Body EventRequest jsonBody);

    @Headers({AppConstatnts.ApiHeader.CONTENT_TYPE_JSON})
    @POST(UrlConstants.CHECK_PROMO_CODE)
    Call<CheckPromoCodeResponse> checkPromoCode(@Header(AppConstatnts.ApiHeader.AUTHORIZATION_HEADER) String authToken, @Body CheckPromoCodeRequest jsonBody);

    @Headers({AppConstatnts.ApiHeader.CONTENT_TYPE_JSON})
    @POST(UrlConstants.LIST_OF_BOOKINGS)
    Call<BookingListResponse> getBookingList(@Header(AppConstatnts.ApiHeader.AUTHORIZATION_HEADER) String authToken);

    @Headers({AppConstatnts.ApiHeader.CONTENT_TYPE_JSON})
    @POST(UrlConstants.SEND_STRIPE_TOKEN)
    Call<StripeResponse> sendToken(@Body StripeRequest jsonBody);


    @Headers({AppConstatnts.ApiHeader.CONTENT_TYPE_JSON})
    @POST(UrlConstants.SAVE_DEBIT_CARD)
    Call<CardResponse> saveCardDatat(@Header(AppConstatnts.ApiHeader.AUTHORIZATION_HEADER) String authToken,@Body CardRequest cardRequest);

    @Headers({AppConstatnts.ApiHeader.CONTENT_TYPE_JSON})
    @POST(UrlConstants.DELETE_DEBIT_CARD)
    Call<DeleteCardResponse> deleteDebitCard(@Header(AppConstatnts.ApiHeader.AUTHORIZATION_HEADER) String authToken, @Body DeleteCardRequest jsonBody);

    @Headers({AppConstatnts.ApiHeader.CONTENT_TYPE_JSON})
    @POST(UrlConstants.BOOKING_REDEMPTION)
    Call<Model> bookingRedemption(@Header(AppConstatnts.ApiHeader.AUTHORIZATION_HEADER) String authToken, @Body BookingRedemptionRequest jsonBody);

    @Headers({AppConstatnts.ApiHeader.CONTENT_TYPE_JSON})
    @POST(UrlConstants.GET_FAVOURITE)
    Call<RestaurantResponse> getFavorite(@Header(AppConstatnts.ApiHeader.AUTHORIZATION_HEADER) String authToken, @Body RestaurantRequest jsonBody);

    @Headers({AppConstatnts.ApiHeader.CONTENT_TYPE_JSON})
    @POST(UrlConstants.SET_FAVOURITE)
    Call<Model> addRemoveFavorite(@Header(AppConstatnts.ApiHeader.AUTHORIZATION_HEADER) String authToken, @Body AddRemoveFavoriteRequest jsonBody);

    @Headers({AppConstatnts.ApiHeader.CONTENT_TYPE_JSON})
    @POST(UrlConstants.LOGOUT)
    Call<Model> logoutFromApp(@Header(AppConstatnts.ApiHeader.AUTHORIZATION_HEADER) String authToken);

    @Headers({AppConstatnts.ApiHeader.CONTENT_TYPE_JSON})
    @POST(UrlConstants.FORGOT_PASSWORD)
    Call<Model> forgotPassword(@Header(AppConstatnts.ApiHeader.AUTHORIZATION_HEADER) String authToken, @Body ForgotPasswordRequest jsonBody);

    @POST(UrlConstants.FAQ)
    Call<FAQResponse> getFAQ();

    @Headers({AppConstatnts.ApiHeader.CONTENT_TYPE_JSON})
    @POST(UrlConstants.EDIT_PROFILE)
    Call<Model> editProfile(@Header(AppConstatnts.ApiHeader.AUTHORIZATION_HEADER) String authToken, @Body ProfileRequest jsonBody);


    @POST(UrlConstants.SIGN_UP_API)
    Call<Model> socialSinup(@Body SocialSinupRequest jsonBody);

    @POST(UrlConstants.SIGN_UP_API)
    Call<SocialLoginResponse> socialLogin(@Body SocialSinupRequest jsonBody);

    @Headers({AppConstatnts.ApiHeader.CONTENT_TYPE_JSON})
    @POST(UrlConstants.GET_STRIPE_TOKEN)
    Call<StripeTokenResponse> getStripeToken(@Body StripeRequest jsonBody);

    @Headers({AppConstatnts.ApiHeader.CONTENT_TYPE_JSON})
    @POST(UrlConstants.BOOK_HOTEL_BAR)
    Call<Model> barBooking(@Header(AppConstatnts.ApiHeader.AUTHORIZATION_HEADER) String authToken, @Body BarBookingRequest barBookingRequest);
}
