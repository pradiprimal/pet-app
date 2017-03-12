<!--<pre>{{petInfo|json}}</pre>-->
<form class="form-horizontal" name="petUpdate" ng-submit="ok()" novalidate="">
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
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-primary">Update</button>
        </div>
    </div>
</form>
