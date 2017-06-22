<%-- 
    Document   : createMenu
    Created on : Apr 9, 2017, 12:48:47 PM
    Author     : pradip
--%>


<!--<pre>{{petInfo|json}}</pre>-->
<div>
    <div ng-show="errorMessage.lenght !== 0"><span style="color: red">{{errorMessage}}</span></div>
    <div ng-show="successMessage.length !== 0"><span style="color: green">{{successMessage}}</div>
    <form class="form-horizontal" name="petRegistration" ng-submit="savePetInfo()" novalidate="">
        <div class="form-group">
            <label class="col-sm-2 control-label">Pet Name</label>
            <div class="col-sm-10">
                <input type="text" ng-model="petInfo.name" class="form-control" id="petName" placeholder="Pet Name" required="">
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-2 control-label">Owner Name</label>
            <div class="col-sm-10">
                <input type="text" ng-model="petInfo.ownerName" class="form-control" id="ownerName" placeholder="Owner Name" required="">
                <span><small></small></span>
            </div>
        </div>

        <div class="form-group">
            <label  class="col-sm-2 control-label">Owner Number</label>
            <div class="col-sm-10">
                <input type="text" ng-model="petInfo.ownerNo" class="form-control" id="ownerNumber" placeholder="Owner Number" required="">
            </div>
        </div>

        <div class="form-group">
            <label  class="col-sm-2 control-label">Owner Email</label>
            <div class="col-sm-10">
                <input type="email" ng-model="petInfo.ownerEmail" class="form-control" id="email" placeholder="Owner Email" required="">
            </div>
        </div>

        <div class="form-group">
            <label  class="col-sm-2 control-label">Address</label>
            <div class="col-sm-10">
                <input type="text" ng-model="petInfo.address" class="form-control" id="address" placeholder="Address" required="">
            </div>
        </div>
        <div class="form-group">
            <label  class="col-sm-2 control-label">Image</label>
            <div class="col-sm-10">
                <input type="file" id="file" name="file"
                       class="input-type-file"
                       ng-model="petImage" base-sixty-four-input
                       accept="image/*"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-primary" ng-disabled="petRegistration.$invalid">Submit</button>
            </div>
        </div>
    </form>
</div>